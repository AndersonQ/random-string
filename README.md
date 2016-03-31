# random-string

A wee Clojure library designed to generate cryptographically secure random strings using Java's SecureRandom.

## Installation

With Leiningen:

```
[random-string "0.1.0"]
```

## Usage

### `(random-string.core/string)`

Returns a random alphanumetic string with length 26.

### `(random-string.core/string len)`

Returns a random alphanumetic string with length `size`.

### `(random-string.core/string len radix)`

Returns a random BigInteger as string with length `len` and base `radix`.

### `(random-string.core/hex-color)`

Return a random hex-color string with a leading `#`

##Test

```
lein test
```

## License

Copyright © 2016 Anderson Queiroz

Distributed under the [GNU General Public License v3](http://www.gnu.org/licenses/gpl-3.0.en.html")
