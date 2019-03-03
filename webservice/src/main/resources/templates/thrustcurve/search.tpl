layout 'layouts/simple.tpl',
page_title: 'Search Thrustcurve API',
banner: contents {
    include template:"layouts/simple/banner.tpl"
},
crumbs: contents {
    include template:"snipit/motors_by_diameter.tpl"
    include template:"snipit/motors_by_impulse.tpl"
},
content: contents {
    br()

    include template:"forms/motor_search.tpl"

},
footer: contents {
    include template:"layouts/simple/footer.tpl"
}
