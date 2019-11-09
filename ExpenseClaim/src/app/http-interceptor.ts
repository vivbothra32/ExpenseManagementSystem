import {HttpEvent, 
    HttpInterceptor, 
    HttpHandler, 
    HttpRequest, 
    HttpResponse, 
    HttpErrorResponse
} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {retry, catchError} from 'rxjs/operators';

export class HttpErrorInterceptor implements HttpInterceptor{

intercept(request:HttpRequest<any>, next:HttpHandler):Observable<HttpEvent<any>>{
    return next.handle(request)
    .pipe(
        retry(1),
        catchError((error: HttpErrorResponse)=>{
            let error_timestamp = error.error.timestamp;
            let error_message = error.error.message;
            let error_details = error.error.details;

            let errorFlag=true;
            let errorMessage='';
            if(error.error instanceof ErrorEvent){
                errorMessage=`Error: ${error.error.message}`;
            }else{
                errorMessage=`${error.error}`;
                console.log(errorMessage);
            }
            if(errorFlag){
                window.alert(error_message);
            }
            return throwError(errorMessage);
        })
    )
}

}