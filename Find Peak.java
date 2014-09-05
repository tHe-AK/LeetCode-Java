public static int findPeak(int[] array) {
    if (array == null || array.length < 3) {
        return -1;
    }

    int low = 0;
    int high = array.length - 1;
    int mid;

    while (low + 1 < high) {
        mid = low + (high - low) / 2;
        if (array[mid - 1] < array[mid] && array[mid] > array[mid + 1]) {
            return mid;
        } else if (array[low] < array[low + 1] && array[mid - 1] > array[mid]) {
            high = mid;
        } else {
            low = mid;
        }
    }
    
    return -1;
}
