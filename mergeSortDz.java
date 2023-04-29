package classwork15042023;

public class mergeSortDz {

    public static void main(String[] args){
        String[] arr = {"яблуко", "банан", "груша", "апельсин", "ківі"};
        mergeSort(arr, 0, arr.length - 1);
        outputResult(arr);
    }

    private static void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Merge
            merge(arr, left, middle, right);
        }
    }

    private static void merge(String[] arr, int left, int middle, int right) {
        String[] leftHalf = new String[middle - left + 1];
        String[] rightHalf = new String[right - middle];

        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = arr[left + i];
        }

        for (int i = 0; i < rightHalf.length; i++) {
            rightHalf[i] = arr[middle + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i].length() <= rightHalf[j].length()) {
                arr[k] = leftHalf[i];
                i++;
            } else {
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftHalf.length) {
            arr[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightHalf.length) {
            arr[k] = rightHalf[j];
            j++;
            k++;
        }
    }


    static void outputResult(String[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
