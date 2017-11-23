require 'date'

puts Date.new
puts Date.new(2016)
puts Date.new(2016, 5)
puts Date.new(2016, 5, 13)

a = 7

def my_value(a)
	a += 10
end

my_value(a)
puts a