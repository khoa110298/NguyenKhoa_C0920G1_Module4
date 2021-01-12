package vn.codegym.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.demo.model.Blog;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog order by post_date desc",nativeQuery = true)
    List<Blog> findAllBlogAndSort();

    Page<Blog> findByNameContaining(Pageable pageable, String keyword);
}
