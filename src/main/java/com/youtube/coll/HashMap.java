package com.youtube.coll;

public class HashMap<K, V> {

    private class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V val) {
            this.key = key;
            this.hash = key.hashCode();
            this.value = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    "} NEXT ==> " + next;
        }
    }

    Node<K, V>[] indexes = new Node[16];

    public void put(K key, V value) {
        assert (key != null);
        int index = getIndex(key);

        Node<K, V> node = new Node<>(key, value);

        if (indexes[index] == null) {
            indexes[index] = node;
        } else { //there is at least 1 node on that array index

            Node<K, V> aux = indexes[index];
            if (aux.key.equals(node.key)) {
                //same key - replace value and return
                aux.value = node.value;
                return;
            }
            //transverse the nodes until you find a key or end
            while (aux.next != null) {
                aux = aux.next;
                if (aux.key.equals(node.key)) {
                    //same key - replace node
                    aux.value = node.value;
                    return;
                }
            }
            //key not found... append in the end
            if (aux.next == null) {
                aux.next = node;
            }
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public V get(K key) {

        assert (key != null);
        Node<K, V> aux = indexes[getIndex(key)];
        if (aux == null) return null;
        if (aux.key.equals(key)) return aux.value;
        while (aux.next != null) {
            aux = aux.next;
            if (aux.key.equals(key)) {
                return aux.value;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.indexes.length; i++) {
            sb.append("[" + i + "]: " + (this.indexes[i] != null ? this.indexes[i].toString() : " <empty>") + "\n");
        }
        return sb.toString();
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % (indexes.length - 1));
    }

    public static void main(String args[]){
        HashMap<Integer, String> hm = new HashMap<>();

        //put
        hm.put("Marcelo".hashCode(), "Marcelo");
        hm.put(0, "Marcelo Twice");
        hm.put("Tavares".hashCode(), "Tavares");
        hm.put("de".hashCode(), "de");
        hm.put("Melo".hashCode(), "Melo");
        hm.put("Nobrega".hashCode(), "Nobrega");
        hm.put("Nobrega".hashCode(), "Nobrega2");
        hm.put("Nobrega".hashCode(), "Nobrega3");
        System.out.println(hm);

        //containsKey
        System.out.println(hm.containsKey("Marcelo".hashCode()));
        System.out.println(hm.containsKey("Marcelo2".hashCode()));
        System.out.println(hm.containsKey(0));
        System.out.println(hm.containsKey("de".hashCode()));

        //get
        System.out.println(hm.get("Marcelo".hashCode()));
        System.out.println(hm.get("Marcelo2".hashCode()));
        System.out.println(hm.get(0));
        System.out.println(hm.get("de".hashCode()));
        System.out.println(hm.get(110));

    }
}


