//Aqui empieza para generar PDF
document.addEventListener("DOMContentLoaded", () => {
    // Escuchamos el click del botón
    const $boton = document.querySelector("#btnCrearPdf");

    $boton.addEventListener("click", () => {
        $('#btnCrearPdf').hide();

        setTimeout(
            function () {
                window.location.href = "listaAlbum.htm";
            }, 2000);

        const $elementoParaConvertir = document.body; // <-- Aquí puedes elegir cualquier elemento del DOM
        html2pdf()
            .set({
                margin: 1,
                filename: 'Lista Album.pdf',
                image: {
                    type: 'jpeg',
                    quality: .98,

                },
                html2canvas: {
                    scale: 2, // A mayor escala, mejores gráficos, pero más peso
                    letterRendering: true,
                },
                jsPDF: {
                    unit: "in",
                    format: "a3",
                    orientation: 'landscape' // landscape o portrait

                }
            })
            .from($elementoParaConvertir)
            .save()
            .catch(err => console.log(err));
    });
});