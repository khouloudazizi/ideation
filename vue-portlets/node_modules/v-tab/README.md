VTab
---

[![npm](https://img.shields.io/npm/v/v-tab.svg)](https://www.npmjs.com/package/v-tab) [![vue2](https://img.shields.io/badge/vue-2.x-brightgreen.svg)](https://vuejs.org/)

> Tab components for Vue.js

Installation
------------

### Using yarn

`yarn add v-tab`

### Using npm

`npm i --save v-tab`

Demo
----

[DEMO](http://dflourusso.github.io/v-tab)

Usage
-----

### Bundler (Webpack, Rollup)

```js
import Vue from 'vue'

import VTab from 'v-tab'

// You need a specific loader for CSS files like https://github.com/webpack/css-loader
import 'v-tab/dist/v-tab.css'

Vue.use(VTab)
```

### Browser

```html
<!-- Include after Vue -->
<link rel="stylesheet" href="v-tab/dist/v-tab.css"></link>
<script src="v-tab/dist/v-tab.js"></script>
<script>
  Vue.use(VTab)
</script>
```

### Example

```html
<template>
  <v-tabs class="v-tab-vertical">
    <v-tab label='First'>
      First tab content
    </v-tab>  
    <v-tab label='Second'>
      Second tab content
    </v-tab>  
    <v-tab label='Third'>
      Third tab content
    </v-tab>  
  </v-tab>
</template>
```

### What about appearence?

Just override the css classes, See the structure:

```stylus
.v-tab
  .v-tab-tabs
    .v-tab-tab
  .v-tab-content
```

Author
-------

-	[Daniel Fernando Lourusso](http://dflourusso.com.br)

License
-------

This project is licensed under [MIT License](http://en.wikipedia.org/wiki/MIT_License)
