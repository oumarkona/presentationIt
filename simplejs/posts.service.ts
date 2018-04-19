
@Ijectable()
export class PostService {
	
	constructor(private http: HttpClient) {
	}

	list() : Observable<Array<Post>> {
		return this.http.get('/api/posts'); 
	}
}


@NgModule({
	// ...
	providers: [ PostService ],
	// ...
})
export class AppModule {

}

@Component({   
	// ...
}) 
export class PostAppComponent {

	constructor(private postService: PostService) {}
}


const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: '/posts',
        component: PostComponent
    },
    {	
        path: '/posts/:id',
        component: PostDetailComponent
    }
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ]
    // ...
})
export class AppModule {
}

ng g c 
ng g d
ng g s
g