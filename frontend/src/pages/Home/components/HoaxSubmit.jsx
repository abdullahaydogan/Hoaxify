import React, { useEffect, useState, useTransition } from "react";
import { useTranslation } from "react-i18next";
import { postHoax } from "./api-postHoax";
import { postHoaxAttachment } from "./api-postHoaxAttachment";
import { Input } from "@/shared/components/Input";

const HoaxSubmit = ()=>{
   const [focussed,setFocussed] = useState(false);
   const {t} =useTranslation();
   const [hoax,setHoax]=useState(" ");
   const [newImage, setNewImage] = useState();
   const [attachmentId,setAttachmentId] = useState();

   useEffect(()=>{
    if(!focussed){
        setHoax("");
        setNewImage();
        setAttachmentId();
    }
   },[focussed]);

   const onClickHoaxify= async ()=>{
    const body ={ 
        content:hoax,
        attachmentId: attachmentId
    }
    try{
       await postHoax(body)
    }catch(error){

    }
   }

   const onChangeFile = event =>{
    if(event.target.files.lenght < 1){
        return;
    }
    const file= event.target.files[0];
    const fileReader = new FileReader();
    fileReader.onloadend = () => {
        setNewImage(fileReader.result);
        uploadFile(file);
    };
    fileReader.readAsDataURL(file);
   };
   
   const uploadFile = async (file) =>{
    const attachment = new FormData();
    attachment.append("file",file);
    const response=  await postHoaxAttachment(attachment);
    setAttachmentId(response.data.id);
   };




    return (
        <div className=" card p-1">
            <div className="flex-fill">
            <textarea
             className="form-control"
              rows={focussed ? 3 : "1"}
               onFocus={()=> setFocussed(true) }
               onChange={ event=> setHoax(event.target.value) }
               value={hoax}
                />
            </div>
           {focussed && (<Input type ="file"  onChange={onChangeFile} /> 
        )}  
            {newImage && <img className="img-thumbnail" src={newImage} alt="hoax-attachment"/> }
            <div className="text-right mt-1 ">
            <button 
            className="btn btn-primary"
            onClick={onClickHoaxify}
            >
            Submit </button>
            <button className="btn btn-light d-inline-flex ml-1" onClick={()=> setFocussed(false)}  >Cancel</button>
            </div>
                
        </div>
    );

}
export default HoaxSubmit;