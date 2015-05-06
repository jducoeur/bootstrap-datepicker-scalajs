# bootstrap-datepicker-scalajs

A Scala.js facade for the bootstrap-datepicker library

## Installation

To use bootstrap-datepicker from Scala.js, add this line to your build.sbt:
```
"org.querki" %%% "bootstrap-datepicker-facade" % "0.1"
```
You will also need to add this line, or something like it, to your HTML, to pull in the matching CSS code:
```
<link rel="stylesheet" href="//cdn.jsdelivr.net/webjars/org.webjars/bootstrap-datepicker/1.4.0/css/bootstrap-datepicker3.min.css">
```
Note that this facade assumes that your site is using Bootstrap for its UI. (If someone wants to fork a standalone variant, feel free.)

## bootstrap-datepicker

This facade wraps around the excellent [bootstrap-datepicker library](https://github.com/eternicode/bootstrap-datepicker). ([Demo](http://eternicode.github.io/bootstrap-datepicker/); [Documentation](http://bootstrap-datepicker.readthedocs.org/en/latest/index.html)) As the name implies, this is a widget, designed for Bootstrap-centric sites, which adds a classic "date picker" -- a popup window to choose a date.

Note that this is *not* a polyfill for the HTML5 date-input type. There is a tradeoff here -- the polyfill approach is conceptually more elegant, especially in the long run. But support for date-input is still quite spotty among the browsers, and the look-and-feel (and quality) is *dramatically* variable among the polyfills. So this provides an approach that is UI-consistent, at least for Bootstrap-based sites.

## Using this facade

For the most part, the facade is pretty obvious. However, note that I have deliberately put a good deal of strongly-typed finish over the raw JS library -- while it's not completely consistent, the Options try to use enumerations instead of raw Strings, and all of the Commands have proper methods defined through the implicit DatepickerCommands class. This should allow you to use the underlying library with a bit more type-safety. 

Also, note the DatepickerEventObject, a variant of JQueryEventObject that is specific to events from this gadget. See [the documentation](http://bootstrap-datepicker.readthedocs.org/en/latest/events.html) for more details. The events themselves do not have a strongly-typed wrapper yet.

To use the Datepicker, attach it to an element of the form:
```
<input type="text" value="05/06/2015"/>
```
using Scala.js code along these lines (this example is from Querki):
```
val baseOpts = BootstrapDatepickerOptions.
  autoclose(true).
  todayHighlight(true).
  todayBtnLinked().
  disableTouchKeyboard(true).
  orientation(Orientation.Top)
// Iff this Date is Optional, show the Clear button:
val opts = 
  if (isOptional)
    baseOpts.clearBtn(true)
  else
    baseOpts
    
$(elem).datepicker(opts)

$(elem).on("changeDate", { rawEvt:JQueryEventObject =>
  save()
})
```
Remember that, as always for jQuery widgets, you should apply this code to the HTML element *after* it gets created in the DOM.

### License

Copyright (c) 2015 Querki Inc. (justin at querki dot net)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
