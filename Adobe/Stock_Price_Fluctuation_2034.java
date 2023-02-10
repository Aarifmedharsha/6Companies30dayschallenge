class StockPrice {
    TreeMap<Integer, Integer> record = new TreeMap<>();
    TreeMap<Integer, Set<Integer>> vals = new TreeMap<>();

    public void update(int timestamp, int price) {
        if (record.containsKey(timestamp)) {
            int prevPrice = record.get(timestamp);
            Set<Integer> book = vals.get(prevPrice);
            book.remove(timestamp);
            if (book.isEmpty()) {
                vals.remove(prevPrice);
            }
        }
        vals.putIfAbsent(price, new HashSet<>());
        vals.get(price).add(timestamp);
        record.put(timestamp, price);
    }

    public int current() {
        return record.lastEntry().getValue();
    }

    public int maximum() {
        return vals.lastKey();
    }

    public int minimum() {
        return vals.firstKey();
    }
}