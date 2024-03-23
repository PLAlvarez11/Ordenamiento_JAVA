package ordenamiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese números separados por coma");
        String cadenaNumeros = scanner.nextLine();
        
        String[] numerosStr = cadenaNumeros.split(",");
        int[] arr = new int[numerosStr.length];
        
        for (int i = 0; i < numerosStr.length; i++) {
        	arr[i] = Integer.parseInt(numerosStr[i]);
        }

        int opcion;
        int N;
        
        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Selección sort");   
                    sort(arr);  
                    printSort(arr); 
                    
                    break;
                case 2:
                    System.out.println("Bubble sort");                              
                    int n = arr.length;
                    bubbleSort(arr, n);
                    printBubble(arr, n);
                    
                    break;
                case 3:
                    System.out.println("Insertion sort");
                    insertion(arr);
                    printInsertion(arr);
                    
                    break;
                case 4:
                    System.out.println("Merge sort");             
                    merge(arr, 0, arr.length - 1);
                    printMerge(arr);
                    
                    break;
                case 5:
                    System.out.println("Quick sort");
                     N = arr.length;
                    quickSort(arr, 0, N - 1);
                    printArrQuick(arr);
                    
                    break;
                case 6:
                    System.out.println("Heap sort");
                    N = arr.length;                    
                    heap(arr);
                    printHeap(arr);
                    
                    break;
                case 7:
                    System.out.println("Counting sort (Conteo)");
                    int[] outputArray = counting(arr);
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(outputArray[i] + " ");
                    }
                    
                    break;
                case 8:
                    System.out.println("Radix sort");
                    N= arr.length;
                    radix(arr, N);
                    printRadix(arr, N);
                    
                    break;
                case 9:
                    System.out.println("Bucket sort");
                    float[] arrF = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
                    bucket(arrF);
                    for (float num : arr) {
                        System.out.print(num + " ");
                    }
                    
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion  < 10);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nElija un opcion para ordenar");
        System.out.println("-------------------------------------");
        System.out.println("1 -> Selection sort");
        System.out.println("2 -> Bubble sort");
        System.out.println("3 -> Insertion sort");
        System.out.println("4 -> Merge sort");
        System.out.println("5 -> Quick sort");
        System.out.println("6 -> Heap sort");
        System.out.println("7 -> Counting sort");
        System.out.println("8 -> Radix sort");
        System.out.println("9 -> Bucket sort");
        System.out.println("10-> Salir");
        System.out.println("-------------------------------------");
        System.out.print("Seleccione una opción: ");
    }
    
    public static void sort(int arr[]) 
    { 
        int n = arr.length; 

        for (int i = 0; i < n-1; i++) 
        { 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 

            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        }
    }
    
    public static void printSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
    
    public static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

        if (swapped == false)
            break;
        }
    }
    
    public static void printBubble(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static void insertion(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    public static void printInsertion(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
    
    
    public static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    public static void merge(int arr[], int l, int r)
    {
        if (l < r) {
 
            int m = l + (r - l) / 2;
 
            merge(arr, l, m);
            merge(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    
    public static  void printMerge(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static  void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {

                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    public static void printArrQuick(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void heap(int arr[])
    {
        int N = arr.length;
 
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        for (int i = N - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    
    public static void heapify(int arr[], int N, int i)
    {
        int largest = i;
        int l = 2 * i + 1; 
        int r = 2 * i + 2;
 
        if (l < N && arr[l] > arr[largest])
            largest = l;

        if (r < N && arr[r] > arr[largest])
            largest = r;
 
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapify(arr, N, largest);
        }
    }
    
    public static void printHeap(int arr[])
    {
        int N = arr.length;
 
        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static int[] counting(int[] inputArray) {
        int N = inputArray.length;
        int M = 0;
 
        for (int i = 0; i < N; i++) {
            M = Math.max(M, inputArray[i]);
        }
 
        int[] countArray = new int[M + 1];
 
        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]]++;
        }
 
        for (int i = 1; i <= M; i++) {
            countArray[i] += countArray[i - 1];
        }
 
        int[] outputArray = new int[N];
 
        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }
 
        return outputArray;
    }
    
    public static void radix(int arr[], int n)
    {
        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    
    public static void printRadix(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    
    public static void bucket(float[] arr) {
        int n = arr.length;

        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bi = (int) (n * arr[i]);
            buckets[bi].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
    
    public static void insertionSort(List<Float> bucket) {
        for (int i = 1; i < bucket.size(); ++i) {
            float key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }
}
