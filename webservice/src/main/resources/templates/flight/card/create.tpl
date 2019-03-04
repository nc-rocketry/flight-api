layout 'layouts/simple.tpl',
page_title: 'Enter New Flight',
crumbs: [ ],
content: contents {
    form(method:"post", target="/api/v1/search/impulse") {
        div(class:"panel") {
            span(class:"field", "first name:")
            input(type:"text", name:"motor_impulse")
        }
        input(type:"text", name:"something")
    }
}
