import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);

        String msg = """
                ===== CHƯƠNG TRÌNH QUẢN LÝ SÁCH =====
                1. Thêm 1 cuốn sách
                2. Xóa 1 cuốn sách
                3. Thay đổi sách
                4. Xuất thông tin tất cả sách
                5. Tìm sách có tiêu đề chứa "lập trình"
                6. Lấy tối đa K sách có giá <= P
                7. Tìm sách theo danh sách tác giả
                0. Thoát
                Chọn chức năng:
                """;

        int chon;
        do {
            System.out.print(msg);
            chon = x.nextInt();
            x.nextLine();

            switch (chon) {
                case 1 -> {
                    Book b = new Book();
                    b.input();
                    listBook.add(b);
                }

                case 2 -> {
                    System.out.print("Nhập mã sách cần xóa: ");
                    int id = x.nextInt();
                    x.nextLine();

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == id)
                            .findFirst()
                            .orElseThrow();

                    listBook.remove(find);
                    System.out.println("Đã xóa sách thành công!");
                }

                case 3 -> {
                    System.out.print("Nhập mã sách cần chỉnh sửa: ");
                    int id = x.nextInt();
                    x.nextLine();

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == id)
                            .findFirst()
                            .orElseThrow();

                    find.input();
                }

                case 4 -> {
                    System.out.println("\nDanh sách sách:");
                    listBook.forEach(Book::output);
                }

                case 5 -> {
                    List<Book> list5 = listBook.stream()
                            .filter(b -> b.getTitle().toLowerCase().contains("lập trình"))
                            .toList();

                    list5.forEach(Book::output);
                }

                case 6 -> {
                    System.out.print("Nhập K: ");
                    int k = x.nextInt();
                    System.out.print("Nhập giá P: ");
                    double p = x.nextDouble();
                    x.nextLine();

                    listBook.stream()
                            .filter(b -> b.getPrice() <= p)
                            .limit(k)
                            .forEach(Book::output);
                }

                case 7 -> {
                    System.out.print("Nhập số tác giả cần tìm: ");
                    int n = x.nextInt();
                    x.nextLine();

                    Set<String> authors = new HashSet<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập tác giả thứ " + (i + 1) + ": ");
                        authors.add(x.nextLine().toLowerCase());
                    }

                    listBook.stream()
                            .filter(b -> authors.contains(b.getAuthor().toLowerCase()))
                            .forEach(Book::output);
                }

                case 0 -> System.out.println("Kết thúc chương trình!");

                default -> System.out.println("Chức năng không hợp lệ!");
            }
        } while (chon != 0);
    }
}
