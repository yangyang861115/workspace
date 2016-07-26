package easy;

/*
 * 278
 * First Bad Version
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. 
 * You should minimize the number of calls to the API
 * */
public class FirstBadVersion {

}

/*
 * The isBadVersion API is defined in the parent class VersionControl. boolean
 * isBadVersion(int version);
 */

//public class Solution2 extends VersionControl {
//    public int firstBadVersion(int n) {
//        int i = 1, j = n;
//        while (i < j) {
//            int middle = i + (j - i) / 2;
//            if (isBadVersion(middle)) {
//                j = middle;
//            } else {
//                i = middle + 1;
//            }
//        }
//        return i;
//    }
//}
