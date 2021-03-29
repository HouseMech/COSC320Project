# COSC 320 001 Analysis of Algorithms 2020W2

## Project Number and Topic: #1 Keyword Replacement Tool

### Group Lead:
Liam

### Group Members:
- Liam
- Joel
- Siying
- Kexin

## Proposal

### Problem Description
In places with a limited amount of character space, people will often resort to keywords in order to express their thoughts. 
The keyword replacement tool finds abbreviations in text passages and replaces them with the proper phrases. For example if a text passage included the string "ASAP" then the tool will replace this with "as soon as possible".

### Edge Cases
- Multiple keywords with no space in between
- Mistypes in keywords
- Different typing habits (with or without certain punctuation marks)
- Upper and lower cases irregularities
- Keywords within a word ("ily" which stands for "i love you" in "luckily")

### Expected Complexities
Some of our group members have only collaborated on coding projects a handful of times so far, so getting ourselves ready to work together over Github will be a challenge. Our project experience is also limited so building something of this scope may be a little overwhelming for our members.

We expect issues to pop up in terms of scheduling. We cannot expect our members to dedicate 100% of their time to the project, so we hope to start well in advance in case of delays.

### Dataset Collection
Course provided dataset.

### Programming Language
Our group members have less experience with Python, so Java will be our language of choice. We will use GitHub to host our repository and we have a private Discord server to facilitate communication.

### Task Separation and Responsibilities
We hope to divide up the work equally as we start. We do not have a good grasp on the limits of everyone’s skills as of yet, but as we work we will be able to more accurately determine our skills. Once that occurs, we can distribute the workload so everyone can apply their skills to the best of their ability. 

### Unexpected Cases/Difficulties
None at the moment.

## Milestone 1

### Problem Formulation
The simplest way to attack this problem would be to loop to check over each word in the input phrase, scanning for a word that matches an abbreviation. For a text of N words and an abbreviation library of M abbreviations, we could logically claim that our runtime is O(M\*N) since we are piggybacking off of Java’s regex string match. If we use a hashmap, with a search time of O(1), M can essentially be ignored. 

### Pseudocode
For (words in input) {
	If (word is in wordmap) {
		Replace word with abbreviation definition;
	} 
}

### Algorithm Analysis
#### Loop Invariant: 
Text input will be split by spaces into an array S. After each iteration i ends, everything to the left of and including i  (S\[0:i + 1]) should already be processed and not contain any abbreviations from the word map.

#### Inductive Hypothesis:
The loop invariant holds for each iteration of the loop
#### Base cases (i=0):
1. If the first element is an abbreviation, it will be replaced with the full definition
1. If the first element is not an abbreviation, it will remain unchanged
#### Inductive Step:
If the inductive hypothesis holds at step i, it holds at step i+1.
In short, if every keyword at S\[0:i+1] has been replaced after step i by the inductive hypothesis, then all keywords in S\[0:i+2] are replaced after step i+1.
#### Conclusion
At the termination of the algorithm, all abbreviations in S have been replaced. 

### Unexpected Cases/Difficulties
- Trying to apply induction to our algorithm was tricky at first. We spent a lot of time knocking our heads against a proverbial wall until we finally found something that made sense.
- Midterm week crammed our schedules and as a result, we found it challenging to find time to finish this document.

### Task Separation and Responsibilities
- Liam Harbec - Created the document and set up group meeting times. Assisted in re-writing and spell-checking. 
- Joel Semeniuk - Helped with the ideas for the algorithms as well as the proofs.
- Siying Wu - Helped with final checking and some editing.
- Kexin Zhao - Major debugging help with proof of correctness.

## Milestone 2

### Algorithm Analysis
Our second algorithm will work similarly to our first. The major difference is that it will run without the use of a hashmap. Each abbreviated keyword will be scanned into our algorithm and then compared with a list of definitions. If a match is found, the keyword is replaced with its definition. Otherwise it will be left alone.

In a tweet of N words and a definition library of M words, the total running time would theoretically be O(M\*N). We would not be able to ignore M unless it is sufficiently small compared to N, especially since we are no longer including the usage of a hashmap. 

#### Loop Invariant: 
Text input will be split by spaces into an array S. After each iteration i ends, everything to the left of and including i  (S\[0:i + 1]) should already be processed and not include abbreviations from the definition library.
#### Inductive Hypothesis:
The loop invariant holds for each iteration of the loop
#### Base cases (i=0):
1. If the first element is an abbreviation, it will be replaced with the full definition
1. If the first element is not an abbreviation, it will remain unchanged
#### Inductive Step:
If the inductive hypothesis holds at step i, it holds at step i+1.
In short, if every keyword at S\[0:i+1] has been replaced after step i by the inductive hypothesis, then all keywords in S\[0:i+2] are replaced after step i+1.
#### Conclusion
At the termination of the algorithm, all abbreviations in S have been replaced. 

### Data Structure
We will use an array of objects to store the definitions for the abbreviations. These objects will contain a key and value property in order to match a specific definition to its abbreviation. In order to replace the abbreviation, we will use a nested loop to check each word against our array of definition objects. 

### Unexpected Cases/Difficulties

- Despite midterm week being over, many classes had project deadlines due right after the midterms, leading to some difficulty in getting the document completed.

- Trying to create a new algorithm to solve this problem was a challenging process. In the end, we used scrapped content from our first algorithm.


### Task Separation and Responsibilities

- Joel - Helped with second algorithm specifics, and data structure rationale.
- Kexin - Debugging help with proof of correctness, assisted with data structure rationale.
- Siying - Help with final checking and some editing.
- Liam - Created the document and almost forgot to set up the group meeting. Assisted in writing the document and spell-checking paragraphs. 

## Milestone 3
