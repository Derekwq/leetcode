# 数字问题


## 数和问题
### Problem 1： 两数之和
https://leetcode-cn.com/problems/two-sum/
#### 题目
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:
> 给定 nums = [2, 7, 11, 15], target = 9  <br>
  因为 nums[0] + nums[1] = 2 + 7 = 9  <br>
  所以返回 [0, 1]  <br>
  
#### 解题思路
使用HashMap, 循环一次即可。 HashMap 的key为数组中某个元素的值，value为该元素的下标。
 target-当前循环元素的值，在HashMap中如果能够get到，则说明之前已经遍历过这个元素了，直接get即可。
 若在HashMap中未get到，则将当前元素的值和下标put到HashMap中。

时间复杂度：o(n)

### Problem 2: 两数相加
https://leetcode-cn.com/problems/add-two-numbers/

#### 题目
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
> 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) <br>
  输出：7 -> 0 -> 8  <br>
  原因：342 + 465 = 807

#### 解题思路
TODO


### Problem 15: 三数之和
https://leetcode-cn.com/problems/3sum/
#### 题目
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例：
> 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，<br>
  满足要求的三元组集合为： <br>
  [   <br>
    [-1, 0, 1], <br>
    [-1, -1, 2]  <br>
  ]
 
#### 解题思路
采用双指针：
先排序 ---> 时间复杂度：o(nlogn)
固定一个数，然后采用两个指针，一前一后。 ---> 时间复杂度：o(n^2)
核心在于去重。

时间复杂度：o(n^2)

### Problem 18: 四数之和
https://leetcode-cn.com/problems/4sum/
#### 题目
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
答案中不可以包含重复的四元组。
示例：
> 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。<br>
  满足要求的四元组集合为： <br>
  [  <br>
    [-1,  0, 0, 1], <br>
    [-2, -1, 1, 2], <br>
    [-2,  0, 0, 2]  <br>
  ]
 
#### 解题思路
同三数之和的解法，双指针。
先排序
固定两个数，然后采用双指针，以前以后。 ---> 时间复杂度：o(n^3)
核心在于去重

（这个解法能够AC，说明用例数据比较简单）


### Problem 167: 两数之和（二）- 输入有序数组
https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/


### Problem 560: 和为K的子数组
https://leetcode-cn.com/problems/subarray-sum-equals-k/


### Problem 653: 两数之和（四）- 输入BST
https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/








