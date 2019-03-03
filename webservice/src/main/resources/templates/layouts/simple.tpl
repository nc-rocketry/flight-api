yieldUnescaped '<!DOCTYPE html>'
html {
    include template: 'layouts/simple/head_meta.tpl'
    body {
        include template:'layouts/simple/navigation.tpl'

        div(class:'container-fluid crumbs-container') { include template:'layouts/simple/breadcrumbs.tpl' }
        br()
        div(class:'container crumbs-container') { include template:'layouts/simple/breadcrumbs.tpl' }
        br()
        div(class:'container content-container') { content() }
        br()

        div(class:'page-footer') { include template:'layouts/simple/footer.tpl' }
        include template:'layouts/simple/page-javascript.tpl'
    }
}
