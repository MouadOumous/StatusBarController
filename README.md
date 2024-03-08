# StatusBarController Library

## Overview
The StatusBarController library provides utility methods for managing the status bar in Android applications. It includes functionality to calculate the status bar height, hide/show the status bar, and check the status of the status bar visibility.

## Installation
To use the StatusBarController library in your Android project, follow these steps:

1. Add the library to your project's dependencies.
2. Import the `StatusBar` class into your code.

## Usage

### Calculating Status Bar Height
Use the `getHeight()` method to dynamically calculate the height of the status bar.

    ```java
    int statusBarHeight = StatusBar.getHeight(activity);
    ```
### Hiding the Status Bar
Use the `hide()` method to hide the status bar.

    ```java
    StatusBar.hide(activity);
    ```
### Showing the Status Bar
Use the `show()` method to show the status bar.

    ```java
    StatusBar.show(activity);
    ```
### Checking Status Bar Visibility
Use the `isHide()` and `isShow()` methods to check the visibility of the status bar.

    ```java
    boolean isStatusBarHidden = StatusBar.isHide(activity);
    boolean isStatusBarVisible = StatusBar.isShow(activity);
    ```
## License

This library is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.

## Contributing

We welcome contributions from the community! If you find any issues or have ideas for improvements, please open an issue or submit a pull request. Your contributions help make this software better for everyone.

To contribute, follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and ensure that tests pass.
4. Commit your changes and push them to your fork.
5. Open a pull request with a clear description of your changes.

Thank you for your interest in contributing to our project!

## Legacy Inspirations

My library, StatusBar, is based on several archived status bar controller libraries that are no longer actively maintained but remain useful as references for building new versions of APIs. These libraries include:

1. [StatusBarUtil](https://github.com/laobie/StatusBarUtil) - An Android library for setting the status bar color and status bar text color.

2. [SystemBarTint](https://github.com/jgilfelt/SystemBarTint) - A library for enabling tinted system bars on Android 4.0 (API 14) and above.

3. [SystemBarTintManager](https://github.com/jgilfelt/SystemBarTint) - A library for enabling tinted system bars on Android 4.0 (API 14) and above.

Although these libraries are no longer actively maintained, they provide valuable insights and implementation examples for managing the status bar in Android applications.
