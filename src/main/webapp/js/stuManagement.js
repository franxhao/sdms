// Write By franxhao


// 弹出添加学生信息模态框
function add() {
    $("#addModal").modal("show");
}

//添加学生信息操作
function add_do(){
    $.ajax({
        url:"addStu",
        method:"post",
        contentType:"application/json;charset=utf-8",
        dataType:"text",
        data:JSON.stringify({
            stuKey:$("#stuKey").val(),
            stuName:$("#stuName").val(),
            stuSex:$("#stuSex").val(),
            stuEnr:$("#stuEnr").val(),
            stuBirth:$("#stuBirth").val(),
            stuCollege:$("#stuCollege").val(),
            stuMajor:$("#stuMajor").val(),
            stuClass:$("#stuClass").val(),
            stuAddress:$("#stuAddress").val(),
            stuTel:$("#stuTel").val()
        }),
        success:function (data) {
            if ("ok" == data){
                //添加成功
                alert("添加成功");
                location.reload();
            }
            if ("fail" == data){
                //添加失败
                alert("添加失败");
            }
            if ("exist" == data){
                alert("该学生已存在，请勿重新上传")
            }
        },
        error:function (err) {
            console.log(err);
        }
    })
}


//点击修改按钮回传学生信息到表格
function edit1(stuKey,stuName) {
    $("#editModal").modal("show");
    $.ajax({
        url:"reEdit",
        method:"post",
        contentType:"application/json;charset=utf-8",
        dataType:"json",
        data:JSON.stringify({
            key:stuKey,
            name:stuName
        }),
        success:function (data) {
            console.log(data)

            // console.log(data[0].stu_key)
            $("#stuKey2").val(data[0].stuKey);
            $("#stuName2").val(data[0].stuName);
            $("#stuSex2").val(data[0].stuSex);
            $("#stuEnr2").val(data[0].stuEnr);
            $("#stuBirth2").val(data[0].stuBirth);
            $("#stuCollege2").val(data[0].stuCollege);
            $("#stuMajor2").val(data[0].stuMajor);
            $("#stuClass2").val(data[0].stuClass);
            $("#stuAddress2").val(data[0].stuAddress);
            $("#stuTel2").val(data[0].stuTel);
        },
        error:function (err) {
            console.log("edit1 err:" + err)
        }
    })
}


//修改学生信息操作
function edit_do() {
    $.ajax({
        url:"stuEdit",
        method:"post",
        contentType:"application/json;charset=utf-8",
        dataType:"text",
        data:JSON.stringify({
            stuKey:$("#stuKey2").val(),
            stuName:$("#stuName2").val(),
            stuSex:$("#stuSex2").val(),
            stuEnr:$("#stuEnr2").val(),
            stuBirth:$("#stuBirth2").val(),
            stuCollege:$("#stuCollege2").val(),
            stuMajor:$("#stuMajor2").val(),
            stuClass:$("#stuClass2").val(),
            stuAddress:$("#stuAddress2").val(),
            stuTel:$("#stuTel2").val(),
        }),
        success:function (data) {
            if ("ok" == data){
                alert("修改成功");
                location.reload();
            }
            if ("fail" == data){
                alert("修改失败");
            }
        },
        error:function (error) {
            console.log("edit_do err: " + error);
        }
    })
}