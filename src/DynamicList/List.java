package DynamicList;

public class List implements IList {

    public List() {
        this._fistNode = null;
        this._lastNode = null;
        this._qtt = 0;
    }

    private Node _fistNode, _lastNode;
    private int _qtt;

    @Override
    public void add(Object value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            _fistNode = newNode;
            _lastNode = _fistNode;
        } else {
            _lastNode.next = newNode;
            _lastNode = newNode;
        }
        this._qtt++;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            removeOfFirst();
        } else if (index == this._qtt) {
            removeOfEnd();
        } else {
            Node anterior = find(index - 1);
            Node atual = anterior.next;
            Node proxima = atual.next;
            anterior.next = proxima;
            proxima.Prev = anterior;
            this._qtt--;
        }

    }

    @Override
    public void alter(Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        return this._fistNode == null;
    }

    @Override
    public Node find(int index) {
        if (isEmpty()) {
            return null;
        } else {
            Node current = _fistNode;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
    }

    @Override
    public Object getElement(int index) {
        return find(index).value;
    }

    private void removeOfFirst() {
        this._fistNode = this._fistNode.next;
        this._qtt--;
    }

    private void removeOfEnd() {
        if (this._qtt == 1) {
            removeOfFirst();
        } else {
            Node penult = this._lastNode.Prev;
            penult.next = null;
            this._lastNode = penult;
            this._qtt--;
        }
    }

}
