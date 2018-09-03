

function generate() {

    var outType = $("#out_type").val();

    var text = $("#text").val();

    if(text == ""){
        swal("文本不能为空");
        return;
    }

    var errorCorrectLevel = $("#error_correct").val();

    var qrCodeLevel = $("#qr_code_level").val();

    var offset = $("#qr_code_level").val();

    var size = $("#size").val();
    $.ajax({
        type: "POST",
        url: "qr_code/generate_qr_code",
        data: {
            outType:outType,
            text:text,
            errorCorrectLevel:errorCorrectLevel,
            qrCodeLevel:qrCodeLevel,
            offset:offset,
            size:size,
        },
        dataType: "json",
        async:true,
        success: function(data){

            var imgList = eval(data.result);

            var html = "";

            for(var key in imgList){

                var str = imgList[key];

                if(outType == "image/jpeg"){
                    html +="<img src='data:imge/jpeg;base64,"+ str +"' alt='load fail' style='margin: 1rem 1rem 1rem 1rem'>";
                }else{
                    html +="<img src='data:imge/png;base64,"+ str +"' alt='load fail' style='margin: 1rem 1rem 1rem 1rem'>";
                }

            }

            document.getElementById("qr_code_result").innerHTML = html;

            $(".alert").show();
            $(".alert b").text(data.data);

        }
    });

    
}