package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Book;
import vn.codegym.service.BookService;

@Controller
public class BorrowBooksController {
    @Autowired
    private BookService booksService;

    @GetMapping({"", "/home"})
    public String home(Model model) {

        model.addAttribute("books", booksService.findAll());
        return "home";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Book booksEntity, RedirectAttributes redirect) {
        this.booksService.save(booksEntity);
        redirect.addFlashAttribute("message", "Create Complete !");
        return "redirect:/home";
    }

    @GetMapping("/detail")
    public String viewBlog(@RequestParam Integer id, Model model) {
        model.addAttribute("book", booksService.findById(id));
        return "detail";
    }

    @GetMapping("/borrow")
    public String borrow(@RequestParam Integer id, RedirectAttributes redirectAttributes) throws Exception {
        this.booksService.borrow(id);
        redirectAttributes.addFlashAttribute("message", "Borrow Complete !"+ booksService.borrow(id));
        return "redirect:/home";
    }

    @GetMapping("/give-back")
    public String showGiveBack(@RequestParam Integer id, Model model) {
        model.addAttribute("id", id);
        return "give-back";
    }

    @PostMapping("/give-back")
    public String giveBack(@RequestParam Integer loanNumber, @RequestParam Integer idBook,
                           RedirectAttributes redirectAttributes) {
        String message = this.booksService.giveBack(loanNumber, idBook);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/home";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException() {
        return "error-book";
    }
}
