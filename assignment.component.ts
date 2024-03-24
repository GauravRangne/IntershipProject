
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-assignment',
  templateUrl: './assignment.component.html',
  styleUrl: './assignment.component.css'
})
export class AssignmentComponent {
  assignmentFile: File | null = null;

  constructor(private http:HttpClient){}

  submitAssignment() {
    if (this.assignmentFile) {
      const formData = new FormData();
      formData.append('file', this.assignmentFile);
      // Here you can perform actions with the assignment file, such as uploading it to a server
      this.http.post("http://localhost:4200/assign",formData).subscribe(
          data =>{
            alert("error");
            console.log(data);
            this.opensweetalert();
            this.resetForm();

          },
          errors =>{
            console.log(errors);
            alert("pass")
            this.opensweetalert();
            this.resetForm();
          }
        )
     
      console.log('Assignment submitted:', this.assignmentFile);

      
      
    }
  }

  opensweetalert(){
    Swal.fire({
      position: "center",
      icon: "success",
      title: "Your work has been saved",
      showConfirmButton: false,
      timer: 1500
    });
  }

  onFileSelected(files: FileList | null) {
    if (files && files.length > 0) {
      this.assignmentFile = files.item(0);
    }
  }

  resetForm() {
    
    this.assignmentFile = null;
    const fileInput = document.getElementById('assignmentFile') as HTMLInputElement;
    fileInput.value = '';
  }
  
}
