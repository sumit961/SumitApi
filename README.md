
# NIT3213 Android Application Development Project

## Overview

This project is developed as part of the NIT3213 final assignment. The application demonstrates proficiency in API integration, user interface design, and adherence to Android development best practices. It consists of three primary screens: Login, Dashboard, and Details, which interact with the **vu-nit3213-api** for user authentication and data retrieval.

## API Details

- **Base URL**: `https://vu-nit3213-api.onrender.com`
- **Endpoints**:
  1. **Login**: `POST` `/footscray/auth` or `/sydney/auth` or `/ort/auth` I used `/Sydney/Auth`
  2. **Dashboard**: `GET` `/dashboard/{keypass}`

## Application Structure

### 1. **Login Screen**
- Allows users to log in with their **first name** as the username and **student ID** (format: `s12345678`) as the password.
- Authenticates the user via the appropriate `/auth` endpoint based on the class location.
- Upon successful login, the user is redirected to the **Dashboard** screen.
- Handles error states, displaying messages for unsuccessful login attempts.

### 2. **Dashboard Screen**
- Displays a list of entities fetched from the dashboard API using a **RecyclerView**.
- Each list item shows a summary of the entity, excluding the description.
- Users can click on individual items to navigate to the **Details** screen.

### 3. **Details Screen**
- Shows detailed information about the selected entity, including the description in a user-friendly layout.

## Features

- **Dependency Injection**: Implemented using [Hilt](https://developer.android.com/training/dependency-injection/hilt) for clean and modular code.
- **RecyclerView**: Used to display lists efficiently in the Dashboard screen.
- **Navigation**: Smooth transitions between Login, Dashboard, and Details screens.
- **Error Handling**: Appropriate error messages are shown for failed login attempts.
- **Unit Testing**: Critical components are covered by unit tests.
- **Version Control**: Managed with Git, maintaining a clear and meaningful commit history.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/sumit961/SumitApi.git
   ```
2. Open the project in Android Studio.
3. Ensure the necessary dependencies are installed by syncing Gradle.
4. Build and run the project on an emulator or a physical device.

## Usage

1. **Login**: Use your **first name** and **student ID** to log in.
2. **Dashboard**: Browse through the list of entities displayed.
3. **Details**: Click on any entity to view more detailed information.


## Dependencies

- **Hilt** for dependency injection
- **Retrofit** for API requests
- **Gson** for JSON parsing
- **RecyclerView** for list display




