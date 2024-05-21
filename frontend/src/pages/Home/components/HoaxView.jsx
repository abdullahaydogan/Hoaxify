import React from "react";
import { format } from "timeago.js";
import ProfileImageWithDefault from "./ProfileImageWithDefault";
import { deleteHoax } from "./api-deleteHoax";
const HoaxView = (props) => {
  const { hoax } = props;
  const { user, content, timestamp , fileAttachment,id} = hoax;
 

  const formatted = format(timestamp);
  

  return (
    <div className="card p-1">
      <div className="d-flex">
        
        <div className="flex-fill m-auto pl-2" >
          <h6 className="d-inline"></h6>
        <span>{formatted}</span>
        </div>
      </div>
      <div className="pl-5">{content}</div>
      { fileAttachment && fileAttachment.name &&(
        <div className="pl-5">
          <img className="img-fluid custom-img" src={  'images/' + fileAttachment.name} alt={content}/>
        </div>
      ) }
     
    </div>
  );
};
export default HoaxView;
