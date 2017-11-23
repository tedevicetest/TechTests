# loop through the array

	numbers = [7, 9, 13, 25, 18, 100, 1, 75, 82]

	count = 0

	until count == numbers.size
		#numbers = numbers.sort # adding this line sorts the numbers
		puts numbers[count]
		count += 1
	end