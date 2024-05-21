import React, { useEffect, useState } from "react";
import {getHoaxes} from "../components/api-getHoaxes";
import { useTranslation } from "react-i18next";
import HoaxView from "./HoaxView";
import { useParams } from "react-router-dom";
const HoaxFeed =()=>{
    const [hoaxPage,setHoaxPage] = useState({content:[] ,last: true,number:0 });
    const {t} = useTranslation();
    const {username} = useParams();

    useEffect(()=>{
        loadHoaxes();
    },[]);

    const loadHoaxes= async(page)=>{
        try{
            const response=await getHoaxes(page);
            setHoaxPage(previousHoaxPage => ({
               ...response.data,
               content: [...previousHoaxPage.content, ...response.data.content] 
            }));
        }catch(error){

        }
    }
    const {content , last, number} = hoaxPage;

    if(hoaxPage.content.length==0){
        return <div className="alert alert-secondary" > {t("There are no Hoaxes")} </div>;
    }


    return(
        <div>
                {content.map(hoax=>{
                    return <HoaxView key={hoax.id} hoax={ hoax}/>;
                })}
                { !last && <div className="alert alert-secondary" style={{cursor:"pointer"}} onClick={()=> loadHoaxes(number + 1)}> {t("Load old Hoaxes")} </div>}
        </div>
    );
}
export default HoaxFeed;