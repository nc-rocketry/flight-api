ul(class:"breadcrumbs") {
    if (crumbs != null) {
        crumbs.each { c -> li { a(href:c.url, c.text) } }
    }
}