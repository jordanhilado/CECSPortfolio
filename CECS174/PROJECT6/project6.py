# Project 6 - CECS 174 Section 02
# Froilan Buendia, Annabel Tapia, Jordan Hilado

# Part A

#True if elements are in ascending order, False otherwise.
print("********** PART A **********")
import time
def is_sorted(my_list):
	if sorted(my_list) == my_list:
		return True
	else:
		return False
print("is_sorted([1, 2, 2]):", is_sorted([1,2,2])) 
print("is_sorted(['b', 'a']):", is_sorted(['b','a']))
print("")

# Part B
print("********** PART B **********")
#Two strings, if anagrams then we should get a True back, False otherwise.
def is_anagram(str1,str2):
	if(sorted(str1) == sorted(str2)):
		return True
	else:
		return False

print("is_anagram(silent, listen):", is_anagram('silent', 'listen'))
print("is_anagram(race, care):",is_anagram('race', 'care'))
print("is_anagram(hi, bye):",is_anagram('hi', 'bye'))
print("")

# Part C
print("********** PART C **********")
#Birthday Paradox

import random
#Given number of students
num_students = 23
#Given number of classrooms
num_classrooms= 1000

#True if an element appears more than once
def has_duplicates(list):
	i = 0
	while i < len(list):
		if list.count(list[i]) > 1:
			return True
		elif i == (len(list) - 1):
			return False
		i += 1
		
#365 days in a year
def random_birthdays():
	return [random.randint(1, 365) for student in range(num_students)]

#Probability of two students having the same birthday
def estimate_birthday_prob(num_classrooms):
	
	duplicate_count = 0
	for i in range(num_classrooms):
		if has_duplicates(random_birthdays()):
			duplicate_count += 1
		
	print("In %d classrooms with %d students, %.1f%% had students with duplicate birthdays." % (num_classrooms, num_students, (float(duplicate_count) / num_classrooms) * 100))

estimate_birthday_prob(num_classrooms)
print("")
# Part D
print("********** PART D **********")
def remove_duplicates(my_list):
  new_list = []
  for i in my_list:
    if i not in new_list:
      new_list.append(i)
  return new_list

duplicate_list = [1,2,2]
print("remove duplicates", duplicate_list)
print("new list:", remove_duplicates(duplicate_list))
print("")
# Part E
print("********** PART E: with append **********")

def append_method(word_list):
  t0 = time.time()
  word_list_append = []
  for i in word_list:
    word_list_append.append(i)
    t1 = time.time() - t0
  print("First 10 words:", word_list_append[0:10])
  print("Time elapsed: ", t1)
  return word_list_append

word_list = open("words.txt","r").read().split()
print("Total words:", len(word_list))
append_method(word_list)
print("")
print("********** PART E: with idiom **********")

def idiom_method(word_list2):
  t0 = time.time()
  word_list_idiom = []
  for i in word_list:
    word_list_idiom = word_list_idiom + [i]
    t1 = time.time() - t0
  print("First 10 words:",word_list_idiom[0:10])
  print("Time elapsed: ", t1)
  return word_list_idiom

print("Total words:", len(word_list))
idiom_method(word_list)
print("The append method is quicker than idiom. I believe this is because the append method is a built-in code for python to add elements into a list. For the idiom equation, a mathematical expression had to be solved for each element in the for loop which will take longer than an in-built command.")
print("")
# Part F
print("********** PART F **********")

def bisect(my_list, word):
  loop = True
  index_value = 0

  if len(my_list) % 2 == 0:
    middle_even = (len(my_list) // 2) - 1
    middle = middle_even
  else:
    middle_odd = len(my_list) // 2
    middle = middle_odd

  while loop:
    if int(my_list[middle]) != int(word) and (len(my_list) < 1 or len(my_list) == 0 or middle < 0 or int(word) < 2): 
      return print(word, "Not found")
      loop = False
    elif int(my_list[middle]) == int(word):
      if my_list[middle] == word and len(my_list) == 1:
        return print(word, "found at index:", index_value)
        loop = False
      elif int(my_list[0]) == int(word):
        return print(word, "found at index:", index_value)
        loop = False
      elif int(my_list[1]) == int(word):
        return print(word, "found at index:", index_value + 1)
        loop = False
      else:
          return print(word, "found at index:", index_value + middle)
          loop = False
    elif int(my_list[middle]) < int(word):
      if len(my_list) % 2 == 0 and len(my_list) > 2:
        index_value += len(my_list[:middle])
        my_list = my_list[middle:]
        middle_even = (len(my_list) // 2) - 1
        middle = middle_even
      else:
        index_value += len(my_list[:middle])
        my_list = my_list[middle:]
        middle_odd = (len(my_list) // 2)
        middle = middle_odd
    elif int(my_list[middle]) > int(word):
      if len(my_list) % 2 == 0:
        my_list = my_list[:middle]
        middle_even = (len(my_list) // 2) - 1
        middle = middle_even
      else:
        my_list = my_list[:middle]
        middle_odd = (len(my_list) // 2)
        middle = middle_odd

my_list = ["2", "5", "8", "45", "47", "67"]
word = "45"
print("bisect(['2', '5', '8', '45', '47', '67']):")
bisect(my_list, word)
my_list = ["2", "5", "8", "45", "47", "67"]
word = "43"
print("bisect(['2', '5', '8', '45', '47', '67']):")
bisect(my_list, word)
print("")

# Part G
print("********** PART G **********")
string = "Hello. This is the string that will be tested with."
def frequencies():
  dictionary = {}
  for i in string:
      if i in dictionary:
          dictionary[i] += 1
      else:
          dictionary[i] = 1
  print("Sorted Dictionary:", sorted(dictionary.items()))
frequencies()
print("")

# Part H
print("********** PART H **********")
file = open("mobysmall.txt", "r")
text = file.read()
words = text.split()

# 1 - Number of words in the file
length_words = len(words)
print("1. Number of words in the textfile:", length_words)
print("")

# 2 - The frequency of each letter in the file
print("2. The frequency of each letter in the file:")
alpha = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
dictionary = {}
def allLetters():
  for i in text:
    if i in alpha:
      if i in dictionary:
          dictionary[i] += 1
      else:
          dictionary[i] = 1
    else:
      continue
  print(sorted(dictionary.items()))
allLetters()
print("")

# 3 - The frequency of upper case letters file
alphaUpper = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
print("3. The frequency of upper case letters in the file:")
dictionary_upper = {}
def upperLetters():
  for i in text:
    if i in alphaUpper:
      if i in dictionary_upper:
          dictionary_upper[i] += 1
      else:
          dictionary_upper[i] = 1
    else:
      continue
  print(sorted(dictionary_upper.items()))
upperLetters()
print("")

# 4 - The frequency of lower case letters in the file
alphaLower = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
print("4. The frequency of lower case letters in the file:")
dictionary_lower = {}
def lowerLetters():
  for i in text:
    if i in alphaLower:
      if i in dictionary_lower:
          dictionary_lower[i] += 1
      else:
          dictionary_lower[i] = 1
    else:
      continue
  print(sorted(dictionary_lower.items()))
lowerLetters()
print("")

# 5 - Convert all uppercase to lower case and vise versa, write in a new file
print("5. Convert all uppercase to lowercase and vice versa, write in a new file.")
print("Started!")
file = open("mobysmall.txt", "r")
text = file.read()
new_file = open("swapcase.txt", "x")
new_file = open("swapcase.txt", "a")
new_file.write(text.swapcase())
new_file.close()
print("Completed!")
print("")

# 6 - Towards the end of the file (or in a new file) write the results of 1 - 4 in an output text file
print("6. - Towards the end of the file (or in a new file) write the results of 1 - 4 in an output text file")
print("Started!")
results = open("results.txt", "x")
results = open("results.txt", "a")
results.write("1. Number of words in the file: ")
results.write(str(length_words))
results.write("\n\n")

results.write("2. The frequency of each letter in the file:")
part2 = str(sorted(dictionary.items()))
results.write(part2)
results.write("\n\n")

results.write("3. The frequency of uppercase letters in the file:")
part3 = str(sorted(dictionary_upper.items()))
results.write(part3)
results.write("\n\n")

results.write("4. The frequency of lowercase letters in the file:")
part4 = str(sorted(dictionary_lower.items()))
results.write(part4)

results.close()
print("Completed!")
print("")

# 7 - Plot the letter frequency
print("7. Plot the letter frequency")
import matplotlib.pyplot as plt
letterfreq = {}
def frequencies():
    for i in text:
        if i in alpha:
            if i in letterfreq:
                letterfreq[i] += 1
            else:
                letterfreq[i] = 1
        else:
            continue
frequencies()
plt.ylabel('Letter Count')
plt.xlabel('Letter')
names = list(letterfreq.keys())
values =  list(letterfreq.values())
plt.bar(range(len(letterfreq)), values, tick_label=names, color='g')
plt.title("Histogram Letter count in a moby.txt file")
plt.show()
print("Good Bye")

# Close the files
new_file.close()
file.close()
word_list.close()