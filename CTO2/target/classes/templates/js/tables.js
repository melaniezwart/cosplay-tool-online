var table = $('table#users').DataTable({
    'ajax' : '/data/users',
    'serverSide' : true,
    columns : [ {
        data : 'id'
    }, {
        data : 'username'
    }, {
        data : 'password'
    }]
});
