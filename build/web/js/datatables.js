$(document).ready(function () {
    $('#tabla').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        },
        
        pageLength: 10,
        lenghtChange: true,
        autoWidth: true,
        bInfo: true,
        bSort: true,
        //BUTTONS
        dom: 'lBfrtip',
        buttons: [{
                extend: 'pdf',
                text: 'PDF',
                className: 'btn btn-danger',
                titleAttr: 'PDF',
                //choose the columns you wish
                exportOptions: {
                    columns: [0, 1, 2]
                }
            },
            //EXCEL
            {
                extend: 'excel',
                text: 'XLSX',
                className: 'btn btn-success',
                titleAttr: 'Excel',
                //choose the columns you wish
                exportOptions: {
                    columns: [0, 1, 2]
                }
            }


        ]
    });
});
