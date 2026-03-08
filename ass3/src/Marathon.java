class Marathon {
    public static void main (String[] arguments) {
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
        };

        int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
            343, 317, 265
        };
        int fastest_time_index = 0;
        int second_fastest_time_index = 0;

        for (int i = 1; i < times.length; i++) {
            if (times[i] < times[fastest_time_index]) {
                fastest_time_index = i;
            }
        }

        if (fastest_time_index == 0) {
            second_fastest_time_index = 1;
        }

        for (int i = 1; i < times.length; i++) {
            if (i != fastest_time_index && times[i] < times[second_fastest_time_index]) {
                second_fastest_time_index = i;
            }
        }
        System.out.println("The fastest runner is " + names[fastest_time_index] + ": " + times[fastest_time_index]);
        System.out.println("The second fastest runner is " + names[second_fastest_time_index ] + ": " + times[second_fastest_time_index ]);
    }
} 