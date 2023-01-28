$(document).ready(function () {
    $('#tabla').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        },
        dom: 'Bfrtip',
        buttons: [{
                extend: 'copy',
                text: 'Copiar',
                className: 'btn btn-secondary',
                color: '#fff',
                exportOptions: {
                    modifier: {
                        page: 'current'
                    }
                }
            },
            {
                extend: 'csv',
                text: 'CSV',
                className: 'btn btn-success',
                titleAttr: 'CSV',
                //choose the columns you wish
                exportOptions: {
                    columns: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
                }
            },
            //PDF
            {
                text: 'PDF',
                className: 'btn btn-danger',
                action: function (e, dt, button, config) {
                    window.location = 'PDFArtista.htm';
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
                    columns: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
                }
            },
            {
                extend: 'print',
                text: 'Imprimir Todo (No solo lo Seleccionado)',
                className: 'btn btn-secondary',
                exportOptions: {
                    modifier: {
                        selected: null
                    },
                    columns: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
                }
            }
        ],
        select: true
    });
});