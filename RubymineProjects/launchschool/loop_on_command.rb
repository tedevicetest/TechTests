loop do
	puts 'Should I stop looping?'
	answer = gets.chomp
	answer.downcase! # This line used so however Yes is typed code only have to check for 'yes'
	break if answer == 'yes'
	puts 'Incorrect answer. Please answer "yes".'
end