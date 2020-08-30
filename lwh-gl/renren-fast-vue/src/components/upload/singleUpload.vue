<template> 
  <div>
<!--    action="http://gulimall-hello.oss-cn-beijing.aliyuncs.com" -->
    <!--:action="fdfsuploadUrl()"-->
    <el-upload
      action="/"
      :data="dataObj"
      list-type="picture"
      :multiple="false" :show-file-list="showFileList"
      :file-list="fileList"
      :before-upload="beforeUpload"
      :on-remove="handleRemove"
      :on-success="handleUploadSuccess"
      :on-preview="handlePreview">
      <el-button size="small" type="primary">点击上传</el-button>
      <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过10MB</div>
    </el-upload>
    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="fileList[0].url" alt="">
    </el-dialog>
  </div>
</template>
<script>
   // import {policy} from './policy'
   // import { getUUID } from '@/utils'
   import {fdfs} from "./fdfs";

  export default {
    name: 'singleUpload',
    props: {
      value: String
    },
    computed: {
      imageUrl() {
        return this.value;
      },
      imageName() {
        if (this.value != null && this.value !== '') {
          return this.value.substr(this.value.lastIndexOf("/") + 1);
        } else {
          return null;
        }
      },
      fileList() {
        return [{
          name: this.imageName,
          url: this.imageUrl
        }]
      },
      showFileList: {
        get: function () {
          return this.value !== null && this.value !== ''&& this.value!==undefined;
        },
        set: function (newValue) {
        }
      }
    },
    data() {
      return {
        dataObj: {
          policy: '',
          signature: '',
          key: '',
          ossaccessKeyId: '',
          dir: '',
          host: '',
          // callback:'',
        },
        dialogVisible: false
      };
    },
    methods: {
      emitInput(val) {
        this.$emit('input', val)
      },
      handleRemove(file, fileList) {
        this.emitInput('');
      },
      handlePreview(file) {
        this.dialogVisible = true;
      },
      fdfsuploadUrl(){
        return window.SITE_CONFIG.baseUrl+'/thirdparty/fdfs/upload'
      },
      beforeUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isGIF = file.type === 'image/gif';
        const isPNG = file.type === 'image/png';
        const isBMP = file.type === 'image/bmp';
        const isLt2M = file.size / 1024 / 1024 < 2;

        // if (!isJPG && !isGIF && !isPNG && !isBMP) {
        //   this.$message.error('上传图片必须是JPG/GIF/PNG/BMP 格式!');
        // }
        // if (!isLt2M) {
        //   this.$message.error('上传图片大小不能超过 2MB!');
        // }
        // return (isJPG || isBMP || isGIF || isPNG) && isLt2M;

        let fd=new FormData();
        fd.append('file',file);
        fd.append('_t1',new Date());

          let _self = this;
          return new Promise((resolve, reject) => {
            fdfs(fd).then(response => {
              console.log("响应的数据",response);
              _self.dataObj.fdfs = response.data.fdfs;
              _self.dataObj.host = response.data.host;
              _self.dataObj.policy = response.data.policy;
              _self.dataObj.signature =file.name;
              console.log("响应的数据222。。。",_self.dataObj);
              resolve(true)

              this.showFileList = true;
              this.fileList.pop();
              this.fileList.push({name: file.name, url: _self.dataObj.fdfs });
              this.emitInput(this.fileList[0].url);

              // this.fileList =[{name:file.name,url:_self.dataObj.policy,status:'finished'}];
            }).catch(err => {
              reject(false)
            })
          })
      },


      //oss
      // beforeUpload(file) {
      //   let _self = this;
      //   return new Promise((resolve, reject) => {
      //     policy().then(response => {
      //       console.log("响应的数据",response);
      //       _self.dataObj.policy = response.data.policy;
      //       _self.dataObj.signature = response.data.signature;
      //       _self.dataObj.ossaccessKeyId = response.data.accessid;
      //       _self.dataObj.key = response.data.dir +getUUID()+'_${filename}';
      //       _self.dataObj.dir = response.data.dir;
      //       _self.dataObj.host = response.data.host;
      //       console.log("响应的数据222。。。",_self.dataObj);
      //       resolve(true)
      //     }).catch(err => {
      //       reject(false)
      //     })
      //   })
      // },
      handleUploadSuccess(res, file) {
        console.log("上传成功...",file)
        this.showFileList = true;
        this.fileList.pop();
        this.fileList.push({name: file.name, url: this.dataObj.host + '/' + this.dataObj.key.replace("${filename}",file.name) });
        this.emitInput(this.fileList[0].url);
      }
    }
  }
</script>
<style>

</style>


