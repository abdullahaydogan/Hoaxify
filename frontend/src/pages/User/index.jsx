import { getUser } from "./api";
import { Alert } from "@/shared/components/Alert";
import { Spinner } from "@/shared/components/Spinner";
import { useRouteParamApiRequest } from "@/shared/hooks/useRouteParamApiRequest";
import { ProfileCard } from "./components/ProfileCard";
import HoaxFeed from "../Home/components/HoaxFeed";


export function User() {
  const {
    apiProgress,
    data: user,
    error,
  } = useRouteParamApiRequest("id", getUser);

  return (
    <div className="container">
        <div className="row">
          <div className="col"> 
          {user && <ProfileCard user={user}/>}
          </div>
          <div className="col">
            <HoaxFeed/>
          </div>
        </div>
      {apiProgress && (
        <Alert styleType="secondary" center>
          <Spinner />
        </Alert>
      )}
      
      {error && <Alert styleType="danger">{error}</Alert>}
    </div>
  );
}
