yieldUnescaped '<!DOCTYPE html>'
html {
    include template:'layouts/simple/head_meta.tpl'
    body {
        div(class:'nav-container') { include template:'layouts/simple/navigation.tpl' }
        div(class:'crumbs-container') { include template:'layouts/simple/breadcrumbs.tpl' }
        div(class:'content-container') { content() }
    }
}
