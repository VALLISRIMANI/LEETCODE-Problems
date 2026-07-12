class Solution {
    class Transaction {
        String original;
        String name;
        int time;
        int amount;
        String city;

        Transaction(String transaction) {
            original = transaction;
            String[] details = transaction.split(",");
            name = details[0];
            time = Integer.parseInt(details[1]);
            amount = Integer.parseInt(details[2]);
            city = details[3];
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        Transaction[] arr = new Transaction[n];
        boolean[] invalid = new boolean[n];

        for (int idx = 0; idx < n; idx++) {
            arr[idx] = new Transaction(transactions[idx]);

            if (arr[idx].amount > 1000) {
                invalid[idx] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].name.equals(arr[j].name) &&
                    Math.abs(arr[i].time - arr[j].time) <= 60 &&
                    !arr[i].city.equals(arr[j].city)
                ) {
                    invalid[i] = true;
                    invalid[j] = true;
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (invalid[i]) {
                result.add(arr[i].original);
            }
        }

        return result;
    }
}