package edu.example.core.streams;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        UserExample u1 = new UserExample(1L,"Tom", "T@gmail.com", 29, true);
        UserExample u2 = new UserExample(2L,"Sam", "S@gmail.com", 30, true);
        UserExample u3 = new UserExample(3L,"Bob", "B@gmail.com", 31, false);
        UserExample u4 = new UserExample(4L,"Nick", "N@gmail.com", 32, true);
        UserExample u5 = new UserExample(5L,"John", "J@gmail.com", 33, true);
        UserExample u6 = new UserExample(6L,"Will", "W@gmail.com", 34, true);
        UserExample u7 = new UserExample(7L,"Jack", "Ja@gmail.com", 33, true);

        ArrayList<UserExample> listOfUsers = new ArrayList<>();
        listOfUsers.add(u1);
        listOfUsers.add(u2);
        listOfUsers.add(u3);
        listOfUsers.add(u4);
        listOfUsers.add(u5);
        listOfUsers.add(u6);
        listOfUsers.add(u7);

        Optional<UserExample> userMax = listOfUsers
                .stream()
                .findFirst();

        if(userMax.isPresent()) {
            System.out.println("userMax = " + userMax.get().toString());
        }
        else{
            System.out.println("something went wrong");
        }

        listOfUsers.stream()
                .map(UserExample::getAge)
                //.map(u->Stream.of(u.getName() + " " + u.getEmail())) //Stream<Stream<String>>
                .forEach(System.out::println);

        //'java doc'
        //### <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        // преобразует элементы типа T в элементы типа R и возвращает поток с элементами R.

        // Отображение или маппинг позволяет задать функцию преобразования одного объекта в другой,
        // то есть получить из элемента одного типа элемент другого типа.

        // Передаваемая в метод map функция задает преобразование от объектов типа T к типу R.
        // И в результате возвращается новый поток с преобразованными объектами.

        /**
         * Returns a stream consisting of the results of applying the given
         * function to the elements of this stream.
         *
         * <p>This is an <a href="package-summary.html#StreamOps">intermediate
         * operation</a>.
         *
         * @param <R> The element type of the new stream
         * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
         *               <a href="package-summary.html#Statelessness">stateless</a>
         *               function to apply to each element
         * @return the new stream
         */

        listOfUsers.stream()
                .flatMap(u->Stream.of(u.getName() + " " + u.getEmail()))
                .forEach(System.out::println);
        //'java doc'
        //### <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        //позволяет преобразовать элемент типа T в несколько элементов типа R и возвращает поток с элементами R.

        // Плоское отображение выполняется тогда, когда из одного элемента нужно получить несколько.
        // То есть из одного объекта нам надо получить два объекта с

        /**
         * Returns a stream consisting of the results of replacing each element of
         * this stream with the contents of a mapped stream produced by applying
         * the provided mapping function to each element.  Each mapped stream is
         * {@link java.util.stream.BaseStream#close() closed} after its contents
         * have been placed into this stream.  (If a mapped stream is {@code null}
         * an empty stream is used, instead.)
         *
         * <p>This is an <a href="package-summary.html#StreamOps">intermediate
         * operation</a>.
         *
         * @apiNote
         * The {@code flatMap()} operation has the effect of applying a one-to-many
         * transformation to the elements of the stream, and then flattening the
         * resulting elements into a new stream.
         *
         * <p><b>Examples.</b>
         *
         * <p>If {@code orders} is a stream of purchase orders, and each purchase
         * order contains a collection of line items, then the following produces a
         * stream containing all the line items in all the orders:
         * <pre>{@code
         *     orders.flatMap(order -> order.getLineItems().stream())...
         * }</pre>
         *
         * <p>If {@code path} is the path to a file, then the following produces a
         * stream of the {@code words} contained in that file:
         * <pre>{@code
         *     Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
         *     Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
         * }</pre>
         * The {@code mapper} function passed to {@code flatMap} splits a line,
         * using a simple regular expression, into an array of words, and then
         * creates a stream of words from that array.
         *
         * @param <R> The element type of the new stream
         * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
         *               <a href="package-summary.html#Statelessness">stateless</a>
         *               function to apply to each element which produces a stream
         *               of new values
         * @return the new stream
         */

        /*
        Both map and flatMap can be applied to a Stream<T> and they both return a Stream<R>.
        The difference is that the map operation produces one output value for each input value,
        whereas the flatMap operation produces an arbitrary number (zero or more) values for each input value.

        This is reflected in the arguments to each operation.

        The map operation takes a Function, is called for each value in the input stream
        and produces one result value, which is sent to the output stream.

        The flatMap operation takes a function that conceptually wants to consume one value
        and produce an arbitrary number of values.
        (number which could be any number it is defined to be but for which no specific value is chosen)

        However, in Java, it's cumbersome for a method to return an arbitrary number of values,
        since methods can return only zero or one value.

        One could imagine an API where the mapper function for flatMap takes a value
        and returns an array or a List of values, which are then sent to the output.

        Given that this is the streams library, a particularly apt way to represent an arbitrary number of return values
        is for the mapper function itself to return a stream!

        The values from the stream returned by the mapper are drained from the stream and are passed to the output stream.
        The "clumps" of values returned by each call to the mapper function
        are not distinguished at all in the output stream, thus the output is said to have been "flattened."

        Typical use is for the mapper function of flatMap to return Stream.empty() if it wants to send zero values,
        or something like Stream.of(a, b, c) if it wants to return several values. But of course any stream can be returned.
         */
    }
}
