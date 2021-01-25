package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Book;
import vn.codegym.model.BookBorrowHistory;
import vn.codegym.service.BookBorrowCardService;
import vn.codegym.service.BookBorrowHistoryService;
import vn.codegym.service.BookService;

@Controller
@RequestMapping("/book")
public class BooksController {
    @Autowired
    BookService bookService;
    @Autowired
    BookBorrowHistoryService bookBorrowHistoryService;
    @Autowired
    BookBorrowCardService bookBorrowCardService;

    @GetMapping({"","/list"})
    public String bookList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "book";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("bookList",bookService.findAll());
        model.addAttribute("bookCartList",bookBorrowCardService.findAll());
        model.addAttribute("borrowBook", new BookBorrowHistory());
        return "create";
    }
//
//    @PostMapping("/create")
//    public String create(@ModelAttribute Book   booksEntity, RedirectAttributes redirect) {
//        this.booksService.save(booksEntity);
//        redirect.addFlashAttribute("message", "Create Complete !");
//        return "redirect:/home";
//    }
//
//    @GetMapping("/detail")
//    public String viewBlog(@RequestParam Integer id, Model model) {
//        model.addAttribute("book", booksService.findById(id));
//        return "detail";
//    }
//
//    @GetMapping("/borrow")
//    public String borrow(@RequestParam Integer id, RedirectAttributes redirectAttributes) throws Exception {
//        this.booksService.borrow(id);
//        redirectAttributes.addFlashAttribute("message", "Borrow Complete !"+ booksService.borrow(id));
//        return "redirect:/home";
//    }
//
//    @GetMapping("/give-back")
//    public String showGiveBack(@RequestParam Integer id, Model model) {
//        model.addAttribute("id", id);
//        return "give-back";
//    }
//
//    @PostMapping("/give-back")
//    public String giveBack(@RequestParam Integer loanNumber, @RequestParam Integer idBook,
//                           RedirectAttributes redirectAttributes) {
//        String message = this.booksService.giveBack(loanNumber, idBook);
//        redirectAttributes.addFlashAttribute("message", message);
//        return "redirect:/home";
//    }
//
//    @ExceptionHandler(value = Exception.class)
//    public String handleException() {
//        return "error-book";
//    }
}
