import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sort {

    private List<Integer> integerArrayList;

    long bubbleSortTime;
    long selectionSortTime;
    long insertionSortTime;
    long mergeSortTime;


    public static void main(String args[]){
        Sort s = new Sort();
        ArrayList<Integer> arrayRandom = new ArrayList<Integer>(10000);
        Random rand = new Random(); rand.setSeed(System.currentTimeMillis());
        for (int i=0; i<10000; i++){
            Integer r = rand.nextInt() % 256; arrayRandom.add(r);
        }

        s.bubbleSort(arrayRandom);
        s.selectionSort(arrayRandom);
        s.insertionSort(arrayRandom);
        s.mergeSort(arrayRandom);
        s.sortTime();

    }

    /**
     *
     * @param integerArrayList
     * @return
     */
    private List<Integer> bubbleSort(List<Integer> integerArrayList){
        long startTime = System.currentTimeMillis();
        int n = integerArrayList.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (integerArrayList.get(j) > integerArrayList.get(j+1))
                {
                    // swap arr[j+1] and arr[i]
                    int temp = integerArrayList.get(j);
                    integerArrayList.set(j,integerArrayList.get(j+1));
                    integerArrayList.set(j+1,temp);
                }

        bubbleSortTime = System.currentTimeMillis()-startTime;
        System.out.println("Bubble Sort Time taken (ms): "+ bubbleSortTime);
        return integerArrayList;

    }

    /**
     *
     * @param integerArrayList
     * @return
     */
    private List<Integer> selectionSort(List<Integer> integerArrayList){
        long startTime = System.currentTimeMillis();
        int n = integerArrayList.size();


        for (int i = 0; i < n-1; i++)
        {

            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (integerArrayList.get(j) < integerArrayList.get(min_idx))
                    min_idx = j;


            int temp = integerArrayList.get(min_idx);
            integerArrayList.set(min_idx, integerArrayList.get(i));
            integerArrayList.set(i,temp);
        }

        selectionSortTime = System.currentTimeMillis()-startTime;
        System.out.println("Selection Sort Time taken (ms): "+ selectionSortTime);

        return integerArrayList;
    }


    /**
     *
     * @param integerArrayList
     * @return
     */
    private List<Integer> insertionSort(List<Integer> integerArrayList){
        long startTime = System.currentTimeMillis();
        int n = integerArrayList.size();
        for (int i = 1; i < n; ++i) {
            int key = integerArrayList.get(i);
            int j = i - 1;

            while (j >= 0 && integerArrayList.get(j) > key) {
                integerArrayList.set(j + 1, integerArrayList.get(j));
                j = j - 1;
            }
            integerArrayList.set(j + 1, key);
        }

        insertionSortTime = System.currentTimeMillis()-startTime;
        System.out.println("Insertion Sort Time taken (ms): "+insertionSortTime);
        return integerArrayList;
    }



    private void divide(int startIndex,int endIndex){

        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid);
            divide(mid+1, endIndex);

            merger(startIndex,mid,endIndex);
        }
    }

    private void merger(int startIndex,int midIndex,int endIndex) {

        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();


        int leftIndex = startIndex;
        int rightIndex = midIndex+1;

        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(integerArrayList.get(leftIndex)<=integerArrayList.get(rightIndex)){
                mergedSortedArray.add(integerArrayList.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(integerArrayList.get(rightIndex));
                rightIndex++;
            }
        }

        //Either of below while loop will execute
        while(leftIndex<=midIndex){
            mergedSortedArray.add(integerArrayList.get(leftIndex));
            leftIndex++;
        }

        while(rightIndex<=endIndex){
            mergedSortedArray.add(integerArrayList.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while(i<mergedSortedArray.size()){
            integerArrayList.set(j, mergedSortedArray.get(i++));
            j++;
        }

    }


    /**
     *
     * @param integerArrayList
     * @return
     */
    private List<Integer> mergeSort(List<Integer> integerArrayList){
        long startTime = System.currentTimeMillis();

        this.integerArrayList = integerArrayList;
        divide(0, this.integerArrayList.size()-1);

        mergeSortTime = System.currentTimeMillis()-startTime;

        System.out.println("Merge Sort Time taken (ms): "+ mergeSortTime);
        return  integerArrayList;

    }


    /**
     * Prints the minimum time taken
     */
    private void sortTime() {

       List<Long> longList = new ArrayList<Long>();
       longList.add(bubbleSortTime);
       longList.add(selectionSortTime);
       longList.add(insertionSortTime);
       longList.add(mergeSortTime);

        Collections.sort(longList);

        System.out.println("Fastest sort" + longList.get(0));
