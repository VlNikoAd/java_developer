package leetcode;

import java.util.HashMap;
import java.util.Map;

//todo вникнуть как гусь
public class SubarraySumEqualsK {

	/*
	Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
	A subarray is a contiguous non-empty sequence of elements within an array.

	Example 1:
	Input: nums = [1,1,1], k = 2
	Output: 2

	Example 2:
	Input: nums = [1,2,3], k = 3
	Output: 2
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		int k = 2;

		int result = subarraySum(nums, k);

		System.out.println("Answer - " + result );

	}

	private static int subarraySum(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer,Integer> preSum = new HashMap<>();
		preSum.put(0,1);
		for(int i=0 ; i<nums.length;i++){
			sum = sum +nums[i];

			if(preSum.containsKey(sum-k)){
				result = result + preSum.get(sum-k);
			}
			preSum.put(sum,preSum.getOrDefault(sum,0)+1);

		}
		return result;
	}
}

/*
Префиксная сумма
Префиксная сумма на некотором индексе i - это сумма всех элементов массива от начала до этого индекса включительно. Например, для массива nums = [1, 2, 3, 4] префиксные суммы будут следующими:

Префиксная сумма до 0 (включая элемент 0): 1
Префиксная сумма до 1: 1 + 2 = 3
Префиксная сумма до 2: 1 + 2 + 3 = 6
Префиксная сумма до 3: 1 + 2 + 3 + 4 = 10
Пример
Теперь рассмотрим, как используется префиксная сумма и хэш-карта на примере:

nums = [1, 1, 1]
k = 2
Алгоритм
Инициализация:

sum = 0 (текущая префиксная сумма)
result = 0 (количество подмассивов)
preSum = {0=1} (хэш-карта для хранения частоты префиксных сумм)
Итерация по массиву:

На каждом шаге добавляем текущий элемент к sum.
Проверяем, есть ли sum - k в preSum. Если есть, это означает, что существует подмассив(ы) с суммой k.
Обновляем хэш-карту, увеличивая частоту текущей префиксной суммы.
Подробный разбор на примере:
Первый элемент:

nums[0] = 1
sum = sum + nums[0] = 0 + 1 = 1
sum - k = 1 - 2 = -1 (нет в preSum)
Обновляем preSum: preSum = {0=1, 1=1}
Второй элемент:

nums[1] = 1
sum = sum + nums[1] = 1 + 1 = 2
sum - k = 2 - 2 = 0 (есть в preSum)
result = result + preSum.get(0) = 0 + 1 = 1
Обновляем preSum: preSum = {0=1, 1=1, 2=1}
Третий элемент:

nums[2] = 1
sum = sum + nums[2] = 2 + 1 = 3
sum - k = 3 - 2 = 1 (есть в preSum)
result = result + preSum.get(1) = 1 + 1 = 2
Обновляем preSum: preSum = {0=1, 1=1, 2=1, 3=1}
Почему это работает
Предположим, у нас есть префиксные суммы P и Q, где Q приходит после P:

Если разница Q - P равна k, значит сумма подмассива между P и Q равна k.
Хэш-карта preSum отслеживает, сколько раз каждая префиксная сумма встречалась, чтобы определить, сколько подмассивов могут завершиться в текущем индексе с нужной суммой k.
Таким образом, когда мы находим, что sum - k существует в preSum, это означает, что есть подмассивы, которые в сумме дают k.

Заключение
Идея заключается в использовании префиксных сумм и хэш-карты для отслеживания количества подмассивов, которые имеют заданную сумму. Это позволяет эффективно находить нужные подмассивы за линейное время.
 */
