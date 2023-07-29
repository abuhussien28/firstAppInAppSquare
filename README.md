# firstTaskAppSaqure
# Registration Screen Validation and HomeScreen and Details
This project implements validation on a registration screen mockup created in Figma.
## 📷 Screenshots from figma 
![taskone](https://github.com/abuhussien28/taskInAppSaquare/assets/96633008/76a5d95b-98ac-4f78-8252-b223e67da76d)

![task two](https://github.com/abuhussien28/taskInAppSaquare/assets/96633008/a5d53987-7f18-47fd-9508-e90aeaecbb8b)


## Overview

The registration screen contains the following fields:

* Name
* Email
* Password
* Phone Number
* City
* Terms & Conditions checkbox

Validation is implemented to check:

* Phone number is 11 digits
* Email contains `@` and `.`
* Password is at least 8 characters
* City field is not empty
* Terms & Conditions is checked

If any validation fails, the user cannot proceed from the `Sign Up` button.
*************************************************************************************
make recycler view and make screen for details of each item 

## Implementation
* The UI is implemented in XML following the Figma mockup
* Input fields use `TextInputLayout` for error handling
* make toast in extension funtions

## Running the Code

The project is built with Gradle. To run it:

1. Clone the repository
2. Open in Android Studio
3.  Run the app on an emulator or connected device

Let me know if you have any other questions!
