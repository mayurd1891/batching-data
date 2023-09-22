public static <T> Stream<List<T>> batched(Stream<T> stream, int batchSize) {
        AtomicInteger count = new AtomicInteger(0);
        return stream
                .collect(Collectors.groupingBy(x -> count.getAndIncrement() / batchSize))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue);
    }
