[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22617069)
# AP CSA Mini‑Project: Data Analysis with Arrays & File Input
### Using CSV Files • Arrays of Objects • Algorithms • Data Ethics & Quality

---

## 📌 Project Overview
In this mini‑project, you will choose a dataset (CSV file), design a **custom class** to represent each row, read the dataset using the **Scanner** class, store all data as **objects** in an ArrayList or array, and answer a **guiding question** by analyzing the data.

This project reinforces:

- Arrays & ArrayLists  
- File input with `Scanner`  
- Class design (attributes, constructors, methods)  
- Algorithms (min, max, average, filtering)  
- Data quality & ethics  
- Documentation using **Javadoc**  
- Creating a **UML class diagram**  

By the end, you will produce insights and answer your original question using your program.

---

## 🎯 Your Task
You will:

1. **Choose a dataset** (teacher provided or public).  
2. **Write a guiding question** for your dataset.  
3. **Design a Java class** with ≥ 3 attributes.  
4. **Use `Scanner` to read a CSV file**, parse rows, and construct objects.  
5. **Store all objects** in an array or ArrayList.  
6. **Analyze the dataset** using algorithms you create.  
7. **Print insights** and answer your guiding question.  
8. **Document your code** with Javadoc.  
9. **Create a UML class diagram** representing your custom class.  

Optional stretch challenges are included at the bottom!

---

## 🧪 Example Questions You Might Ask
Your dataset might allow you to answer things like:

- *"Which Pokémon type has the highest average Attack?"*  
- *"Which U.S. state had the lowest obesity rate in 2020?"*  
- *"What country had the highest CO₂ emissions in 2000?"*  
- *"What is the average HP for Fire-type Pokémon?"*  

Think simple, clear, and answerable.

---

## 📁 Project Structure
Your repository should follow this structure:
```
/src
    Main.java
    YourClass.java
/data
    your_dataset.csv
README.md   ← this file
UML_Diagram.png (or UML_Diagram.pdf)
```

---

## 🧩 Step 1 — Choose Your Dataset

**Dataset Name:** Epstein flight records (cleaned)
**Source / Link:** Teacher‑provided CSV

**What this dataset contains (2–3 sentences):**
The file contains a list of individuals connected to Jeffrey Epstein along
with the number of flights they took and their nationality.  Each row is a
person record; the important columns for this project are name, flight count,
and nationality.

## ❓ Step 2 — Write Your Guiding Question

Your guiding question should be something you can answer using your dataset.

**My guiding question:**  
How many total flights were taken by each individual, who took the most flights,
which people flew more than 100 times, and how are flights distributed by
nationality?

---

## 🧱 Step 3 — Design Your Class

You must create a class that represents **one row** of your dataset.

### ✔ Your class must include:

- **At least 3 private attributes**  
- **A constructor** that takes all attributes as parameters  
- **Getter methods** for attributes you plan to analyze  
- **`toString()`** for easy printing  
- Any additional analysis/helper methods as needed  

### ✏ Include your class diagram
(See `UML_Diagram.png` for a simple class diagram showing attributes and
methods of the `Person` class.)


---

## 📥 Step 4 — Read Your CSV File Using Scanner

In `App.java` (or `Main.java`), you must:

- Create a `File` object pointing at the Epstein CSV
- Use `Scanner` to read the file
- Skip the header row
- Read each line
- Split by commas (taking care with quoted fields)
- Trim whitespace
- Parse the flight count as an integer
- Construct `Person` objects
- Add them to an `ArrayList<Person>`

### Column → Attribute Map

| Attribute Name | CSV Column Name     | Column Index # | Notes |
|----------------|----------------------|----------------|-------|
| name           | Name                 | 1              | full name of individual |
| flights        | Total Flights        | 5              | may include non‑numeric characters |
| nationality    | Nationality          | 9              | can be empty |

---

## 📊 Step 5 — Analyze Your Data

You must write **at least two algorithms** to analyze your dataset.

### Required: Choose 2 or more algorithms
- [ ] Maximum value of attribute
- [ ] Sorting
- [ ] Filter or group by category
- [ ] Counting items that meet a condition

**Algorithms I will implement:**

1. Sort individuals by flight count (descending)
2. Find the person with the maximum number of flights
3. List all individuals with more than 100 flights
4. Compute total flights by nationality

Optional extras:
- Top/bottom N items
- Additional grouping or statistics

---

## 🧠 Step 6 — Insights & Answer to Your Question

After analyzing your objects, print:

- ✔ How many rows were loaded
- ✔ Your algorithm results
- ✔ A clear answer to your guiding question

**My findings:**
- Total records loaded: 1264 person entries from the Epstein dataset.
- The individual with the most flights was Jeffrey Epstein (553 flights),
  followed by Ghislaine Maxwell and others.
- Six people flew more than 100 times.
- Flights are heavily skewed toward American nationals, who account for the
  vast majority of flights.

**My answer to the guiding question:**
Jeffrey Epstein took the most flights (553).  Only a handful of individuals
flew more than 100 times, and Americans dominated the total flight counts.
---

## 📝 Step 7 — Documentation Requirements
*Javadoc comments have been added to every class, constructor, and method in
`Person.java` and `App.java`.*
### ✔ Javadoc Comments
You MUST use Javadoc for:

- Every **class**  
- Every **method**  
- Every **parameter**  
- Every **return value**  

Example:
```java
/**
 * Returns the highest HP among all Pokémon.
 * @param list the ArrayList of Pokémon objects
 * @return highest HP value in the dataset
 */
public static int findMaxHP(ArrayList<Pokemon> list) {
    // implementation
}
```

### ✔ UML Class Diagram
Add a UML diagram showing:

- Class name
- Attributes
- Methods
- Visibility (private/public)

Save as `UML_Diagram.png` or `.pdf` in the repo.

---

## 🛡 Step 8 — Data Ethics & Quality Reflection
Write a short reflection (3–5 sentences):

- What data-quality issues did you find?
- Could your dataset be biased?
- How might incomplete or inaccurate data affect results?
- How trustworthy are your insights?

**My reflection:**  
- Some entries use `-1` to mark missing nutrient values, which could skew
  averages if not handled.
- The dataset only covers a specific set of individuals and may omit
  others, so the results are not representative of all air travelers.
  so it may not be representative of all products or current formulations.
- Consumer ratings are subjective and the criteria for scoring are unknown,
  introducing potential bias.
- Any errors or omissions in the CSV would directly affect the computed
  statistics, so conclusions should be drawn cautiously.

---

## ⭐ Optional Challenges (Not Required but Fun!)

### 🔹 User Input
Allow the user to choose:

- Which attribute to analyze
- Which category to filter
- What statistics they want to calculate

### 🔹 Additional Algorithms

- Sorting objects
- Multiple comparisons
- Generating summaries
- Exporting results to a file

### 🔹 Data Cleaning

- Skip rows with missing values
- Detect invalid entries
- Normalize units

---

## ✅ Submission Checklist

- [ ] Dataset selected
- [ ] Guiding question written
- [ ] Class created with ≥3 attributes
- [ ] File reading implemented
- [ ] ArrayList/array of objects created
- [ ] At least 2 analysis algorithms implemented
- [ ] Findings printed
- [ ] Javadoc comments added
- [ ] UML diagram included
- [ ] Reflection completed
- [ ] Code compiles & runs

---

Good luck, and have fun exploring your dataset! 🚀  
You're now doing real data analysis — just like professional software engineers.
