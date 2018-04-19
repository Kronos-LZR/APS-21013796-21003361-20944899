package DynamicList;

public interface IList {
    void add(Object value);
    void remove(int index);
    void alter(Object value);
    boolean isEmpty();
    Node find(int index);
    Object getElement(int index);
}
