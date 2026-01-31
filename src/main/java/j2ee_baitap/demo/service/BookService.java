package j2ee_baitap.demo.service;

import org.springframework.stereotype.Service;

import j2ee_baitap.demo.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    // Khởi tạo danh sách lưu trữ sách tạm thời trong bộ nhớ
    private List<Book> books = new ArrayList<>();

    // 1. Lấy danh sách tất cả các sách
    public List<Book> getAllBooks() {
        return books;
    }

    // 2. Tìm một cuốn sách dựa trên ID
    public Book getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id)
                .findFirst().orElse(null);
    }

    // 3. Thêm một cuốn sách mới vào danh sách
    public void addBook(Book book) {
        books.add(book);
    }

    // 4. Cập nhật thông tin sách hiện có
    public void updateBook(int id, Book updatedBook) {
        books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .ifPresent(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                });
    }

    // 5. Xóa một cuốn sách khỏi danh sách theo ID
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}