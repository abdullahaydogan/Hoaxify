import React from "react";


import { UserList } from "./components/UserList";
import HoaxSubmit from "./components/HoaxSubmit";
import HoaxFeed from "./components/HoaxFeed";


export function Home() {
    
  return (
    <div className="container">
      <div className="row">
        <div className="col">
         <div className="mb-1">
       <HoaxSubmit/>
         </div>
         <HoaxFeed/>
        </div>
        <div className="col">
          <UserList />
        </div>
      </div>
    </div>
  );
}
