# File manager 👋
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](MIT)
[![Build Status](https://travis-ci.com/serveriev/file-manager.svg?branch=master)](https://travis-ci.com/serveriev/file-manager)

> The tool manipulates files.

## Install

```sh
mvn clean install
```

## Run

```sh
java -jar target/file-manager-1.0.jar
```

## Usage

Tool accepts arguments by priority: [command] [path] [file] [text]. The [text] argument is not required.

There are available commands:

* **create** 
* **info** 
* **read** 
* **exit** 

For example, if you want to create a file, you should pass arguments:
```sh
create . test.txt Test
```

## Run tests

```sh
mvn test
```

## Author

👤 **Lenur**

* Github: [@serveriev](https://github.com/serveriev)

## Show your support

Give a ⭐️ if this project helped you!

## 📝 License

Copyright © 2020 [Lenur](https://github.com/serveriev).

This project is [MIT](MIT) licensed.
