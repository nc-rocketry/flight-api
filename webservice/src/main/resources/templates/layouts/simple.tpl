yieldUnescaped '<!DOCTYPE html>'
html {
    include template: 'layouts/simple/head_meta.tpl'
    body {
        include template:'layouts/simple/navigation.tpl'

        div(class:"headline") {
            div(class:'container-fluid content-container') { banner() }
        }
        div(class:"crumbs") {
            div(class:'container-fluid content-container') { crumbs() }
        }
        div(class:"main") {
            div(class:'container-fluid content-container') { content() }
        }
        div(class:"footer") {
            div(class:'container-fluid content-container') { include template:'layouts/simple/footer.tpl' }
        }

        include template:'layouts/simple/page-javascript.tpl'
    }
}
