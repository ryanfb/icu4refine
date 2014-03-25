ICU4Refine
==========

ICU4Refine is a simple [ICU Transliteration](http://userguide.icu-project.org/transforms/general) extension for [OpenRefine](http://openrefine.org/).

It adds the [GREL](https://github.com/OpenRefine/OpenRefine/wiki/Google-refine-expression-language) string function:

    transliterate(string transform, string input)

Which will return `input` transliterated according to the rules in conversion rules in `transform`.

For example, `transliterate("NFC; Greek-Latin; NFD; [:Nonspacing Mark:] Remove; NFC","μῆνιν ἄειδε θεὰ Πηληϊάδεω Ἀχιλῆος")` will return `"menin aeide thea Peleiadeo Achileos"`.

Installation
------------

Copy `icu4refine` into the `webapp/extensions` folder of OpenRefine.

On OS X, this will be `/Applications/Google Refine.app/Contents/Resources/webapp/extensions`.